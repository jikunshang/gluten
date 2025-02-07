/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql

class GlutenJoinSuite extends JoinSuite with GlutenSQLTestsTrait {

  override def testNameBlackList: Seq[String] = Seq(
    // Below tests are to verify operators, just skip.
    "join operator selection",
    "broadcasted hash join operator selection",
    "broadcasted hash outer join operator selection",
    "broadcasted existence join operator selection",
    "SPARK-28323: PythonUDF should be able to use in join condition",
    "SPARK-28345: PythonUDF predicate should be able to pushdown to join",
    "cross join with broadcast",
    "test SortMergeJoin output ordering",
    "SPARK-22445 Respect stream-side child's needCopyResult in BroadcastHashJoin",
    "SPARK-32330: Preserve shuffled hash join build side partitioning",
    "SPARK-32383: Preserve hash join (BHJ and SHJ) stream side ordering",
    "SPARK-32399: Full outer shuffled hash join",
    "SPARK-32649: Optimize BHJ/SHJ inner/semi join with empty hashed relation",
    "SPARK-34593: Preserve broadcast nested loop join partitioning and ordering",
    "SPARK-35984: Config to force applying shuffled hash join",
    "test SortMergeJoin (with spill)",
    // NaN is not supported currently, just skip.
    "NaN and -0.0 in join keys"
  )
}
