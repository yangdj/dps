package tf.streaming

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.streaming.Trigger
import tf.sinks.HbaseSink

object Kafka2Hbase {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .appName("kafka2hbase")
      .getOrCreate

    val readData = spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "hpmaster:9092")
      .option("subscribe", "test")
      .option("startingOffsets", "earliest")
      .load()
      .selectExpr("cast(value as STRING) as value")

    val writeData = readData.writeStream
      .foreach(new HbaseSink("hpmaster", "test", "cf", "name"))
      .trigger(Trigger.ProcessingTime("5 seconds"))
      .option("checkpointLocation", "checkpoint")
      .outputMode("append")
      .start()

    writeData.awaitTermination()
  }
}