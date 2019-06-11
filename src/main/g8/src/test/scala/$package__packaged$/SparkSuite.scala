package $package$

import org.apache.spark.sql.{DataFrame, SparkSession}

trait SparkSuite {
    def withSpark(testCode: SparkSession => Any) {
        val spark = SparkSession.builder()
          .master("local[*]")
          .appName("$name$")
          .getOrCreate()
        try testCode(spark)
        finally spark.close()
    }

    def withSparkDataFrame(testCode: (SparkSession, DataFrame) => Any): Unit = {
        withSpark {spark =>
          import spark.implicits._
          val df = spark.sparkContext.parallelize(List("quick","brown","fox")).toDF
          testCode(spark,df)
        }
    }
}