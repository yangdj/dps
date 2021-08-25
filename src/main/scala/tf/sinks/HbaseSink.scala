package tf.sinks

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.client.{Connection, ConnectionFactory, Put, Table}
import org.apache.hadoop.hbase.{HBaseConfiguration, HConstants, TableName}
import org.apache.spark.sql.{ForeachWriter, Row}

class HbaseSink(zookeeper_quorum: String,
                table_name: String,
                column_family: String,
                col_name: String) extends ForeachWriter[Row] {
  var conn: Connection = _
  var table: Table = _

  override def open(partitionId: Long, epochId: Long): Boolean = {
    val config: Configuration = HBaseConfiguration.create()
    config.set(HConstants.ZOOKEEPER_QUORUM, zookeeper_quorum)
    config.set(HConstants.ZOOKEEPER_CLIENT_PORT, "2181")
    conn = ConnectionFactory.createConnection(config)
    table = conn.getTable(TableName.valueOf(table_name))
    true
  }

  override def process(value: Row) = {
    var rowid = String.valueOf(System.currentTimeMillis())
    var v = value.getAs("value").toString
    var put = new Put(rowid.getBytes())
    put.addColumn(column_family.getBytes(), col_name.getBytes(), v.getBytes())
    table.put(put)
  }

  override def close(errorOrNull: Throwable) = {
    table.close()
    conn.close()
  }
}
