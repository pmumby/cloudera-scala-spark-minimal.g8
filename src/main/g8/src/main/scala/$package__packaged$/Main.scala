package $package$

import org.apache.spark.internal.Logging
import org.apache.spark.sql.SparkSession

object Main extends App with Logging {

  //Instantiate Spark Session
  val spark = SparkSession.builder()
    .master("yarn")
    .appName("$name$")
    .getOrCreate()

  //Job Logic Goes Here
  log.info("Application $name$ Starting...")
  val job = new Job(spark)
  job.start

  //Close Spark Session When Done
  spark.close()

}
