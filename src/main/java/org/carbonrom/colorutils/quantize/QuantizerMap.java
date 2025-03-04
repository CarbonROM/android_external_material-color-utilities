/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.carbonrom.colorutils.quantize;

import java.util.HashMap;
import java.util.Map;

/** Creates a dictionary with keys of colors, and values of count of the color */
public final class QuantizerMap implements Quantizer {
  Map<Integer, Integer> colorToCount;

  @Override
  public QuantizerResult quantize(int[] pixels, int colorCount) {
    final HashMap<Integer, Integer> pixelByCount = new HashMap<>();
    for (int pixel : pixels) {
      pixelByCount.merge(pixel, 1, (Integer count, Integer newValue) -> count + newValue);
    }
    colorToCount = pixelByCount;
    return new QuantizerResult(pixelByCount);
  }

  public Map<Integer, Integer> getColorToCount() {
    return colorToCount;
  }
}
