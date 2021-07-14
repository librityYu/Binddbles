/*
 * Designed and developed by 2021 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pince.pokexactivity.bean

import android.os.Parcel
import android.os.Parcelable

data class Poster(
  val name: String?,
  val release: String?,
  val playtime: String?,
  val description: String?,
  val poster: String?
) : Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(name)
    parcel.writeString(release)
    parcel.writeString(playtime)
    parcel.writeString(description)
    parcel.writeString(poster)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<Poster> {
    override fun createFromParcel(parcel: Parcel): Poster {
      return Poster(parcel)
    }

    override fun newArray(size: Int): Array<Poster?> {
      return arrayOfNulls(size)
    }
  }
}
