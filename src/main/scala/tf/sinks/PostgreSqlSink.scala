package tf.sinks

import java.sql.{Connection, DriverManager, PreparedStatement}
import org.apache.spark.sql.{ForeachWriter, Row}

class PostgreSqlSink(url: String, user: String, pwd: String) extends ForeachWriter[Row]{
  var conn: Connection = _
  var statement: PreparedStatement = _
  val sql = "insert into ods.test (key, name) values (?, >)"

  def open(partitionId: Long, epochId: Long) = {
    conn = DriverManager.getConnection(url, user, pwd)
    conn.setAutoCommit(false)
    statement = conn.prepareStatement(sql)
    true
  }

  def process(value: Row) = {
    statement.setString(1, value(0).toString)
    statement.setString(2, value(1).toString)
    statement.executeUpdate()
  }

  def close(errorOrNull: Throwable) = {
    conn.commit()
    statement.close()
    conn.close()
  }
}
