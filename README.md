# cloudera-scala-spark-minimal
Minimal Scala Spark Project Gitter8 Template for Cloudera CDH 6.x

## Usage
Use SBT to instantiate a new project based on the template:
```sbt new pmumby/cloudera-scala-spark-minimal.g8```

Answer prompts to configure project appropriately.

Put your code logic in Job.scala (or other classes called from there)

Write unit tests as appropriate

To Test: ```sbt test```
To Compile: ```sbt compile```
To Package for Spark Submit: ```sbt assembly```

See JobSpec for example unit test case.
