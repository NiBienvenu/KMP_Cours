package com.nibienvenu.kmp_cours.ComposeTheme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object ComposeTheme {
    object colors {
        val gray100 = Color(0xFFF3F4F6)
        val gray800 = Color(0xFF1F2937)
    }

    object shapes {
        val roundL = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
    }

    object textStyles {
        val base = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        val sm = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 20.sp
        )
    }
}