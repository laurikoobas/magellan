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

package org.apache.magellan

import org.scalatest.FunSuite

class LineSuite extends FunSuite {

  test("touches") {
    val line1 = new Line(new Point(0.0, 0.0), new Point(1.0, 0.0))
    val line2 = new Line(new Point(0.0, 0.0), new Point(0.0, 1.0))
    assert(line1.touches(line2))
    assert(line1.touches(new Point(0.0, 0.0)))
    assert(new Point(0.0, 0.0).touches(line1))
    assert(new Point(1.0, 0.0).touches(line1))
    assert(line2.intersects(new Line(new Point(-0.5, 0.5), new Point(0.5, 0.5))))
  }

  test("intersects") {
    val line1 = new Line(new Point(0.0, 0.0), new Point(1.0, 0.0))
    val line2 = new Line(new Point(0.0, 0.0), new Point(0.0, 1.0))
    assert(line1.intersects(line2, 3))
    assert(line2.intersects(new Line(new Point(-0.5, 0.5), new Point(0.5, 0.5)), 3))
  }
}
