package com.example.bofatyreva_veronika_shop


import org.junit.Test

import org.junit.Assert.*
import java.lang.Math.pow
import kotlin.math.sqrt

class IncrementTest {
    @Test
    fun incrementTest() {
        var i = 1
        i += 1
        assertEquals(2, i)
    }
}