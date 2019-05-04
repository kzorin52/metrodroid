/*
 * ISO7816SelectorByName.java
 *
 * Copyright 2018 Google
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package au.id.micolous.metrodroid.card.iso7816

import au.id.micolous.metrodroid.util.ImmutableByteArray

internal data class ISO7816SelectorByName (val name: ImmutableByteArray): ISO7816SelectorElement(KIND) {
    override suspend fun select(tag: ISO7816Protocol): ImmutableByteArray {
        return tag.selectByName(name, false)
    }

    override fun formatString(): String {
        return "#" + name.toHexString()
    }

    companion object {
        const val KIND = "name"
    }
}
