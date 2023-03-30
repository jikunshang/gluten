import com.databricks.spark.sql.perf.tpch._


val scaleFactor = "10" // scaleFactor defines the size of the dataset to generate (in GB).
val numPartitions = 1  // how many dsdgen partitions to run - number of input tasks.

val format = "parquet" // valid spark format like parquet "parquet".
val rootDir = "hdfs://4b0f23b06d9b:9000/disk1/tpch-data/sf10_inone" // root directory of location to create data in.
val dbgenDir = "/workspace/tpch-dbgen_1/" // location of dbgen

val tables = new TPCHTables(spark.sqlContext,
    dbgenDir = dbgenDir,
    scaleFactor = scaleFactor,
    useDoubleForDecimal = true, // true to replace DecimalType with DoubleType
    useStringForDate = true) // true to replace DateType with StringType


tables.genData(
    location = rootDir,
    format = format,
    overwrite = true, // overwrite the data that is already there
    partitionTables = false, // do not create the partitioned fact tables
    clusterByPartitionColumns = false, // shuffle to get partitions coalesced into single files.
    filterOutNullPartitionValues = false, // true to filter out the partition with NULL key value
    tableFilter = "", // "" means generate all tables
    numPartitions = numPartitions) // how many dsdgen partitions to run - number of input tasks.

