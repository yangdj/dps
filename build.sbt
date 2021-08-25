name := "tf"

version := "0.1"

scalaVersion := "2.12.14"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "3.1.2",
  "org.apache.spark" % "spark-sql-kafka-0-10_2.12" % "3.1.2",
  "org.apache.hbase" % "hbase-client" % "2.3.5",
  "org.postgresql" % "postgresql" % "42.2.16"
)

