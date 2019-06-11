package $package$

import org.apache.spark.internal.Logging
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

class Job(val spark:SparkSession) extends Logging {

    def start = {
        log.info("Job Start!")
    }

    def helloTransform(df:DataFrame):DataFrame = {
        df.withColumn("greeting",lit("Hello World!"))
    }
}