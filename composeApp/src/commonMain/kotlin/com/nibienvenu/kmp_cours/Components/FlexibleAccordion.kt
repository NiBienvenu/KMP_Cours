package com.nibienvenu.kmp_cours.Components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Checkbox
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FilterChip
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.nibienvenu.kmp_cours.ComposeTheme.ComposeTheme

data class AccordionItem(
    val title: String,
    val content: AccordionContent
)

data class AccordionContent(
    val type: ContentType,
    val items: List<String>
)

enum class ContentType {
    TEXT, CHECKBOX, CHIP
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FlexibleAccordion() {
    val accordionItems = listOf(
        AccordionItem(
            title = "Product Categories",
            content = AccordionContent(
                type = ContentType.TEXT,
                items = listOf(
                    "Electronics", "Fashion", "Home & Kitchen",
                    "Books", "Sports & Outdoors"
                )
            )
        ),
        AccordionItem(
            title = "User Preferences",
            content = AccordionContent(
                type = ContentType.CHECKBOX,
                items = listOf(
                    "Dark Mode", "Notifications", "Location Services",
                    "Language Sync", "Analytics Tracking"
                )
            )
        ),
        AccordionItem(
            title = "Technology Skills",
            content = AccordionContent(
                type = ContentType.CHIP,
                items = listOf(
                    "Python", "JavaScript", "React", "Kotlin",
                    "Swift", "Java", "TypeScript", "Go"
                )
            )
        ),
        AccordionItem(
            title = "Support Resources",
            content = AccordionContent(
                type = ContentType.TEXT,
                items = listOf(
                    "Help Center", "Community Forum", "Video Tutorials",
                    "Technical Support", "User Guides"
                )
            )
        ),
        AccordionItem(
            title = "Contact Methods",
            content = AccordionContent(
                type = ContentType.TEXT,
                items = listOf(
                    "Email Support", "Phone Line", "Live Chat",
                    "Social Media", "Ticket System"
                )
            )
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(accordionItems) { item ->
                ExpandableAccordionItem(item)
            }
        }
    }
}

@Composable
fun ExpandableAccordionItem(
    item: AccordionItem
) {
    var expanded by remember { mutableStateOf(false) }
    val degrees by animateFloatAsState(if (expanded) -90f else 90f)

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { expanded = !expanded },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicText(
                text = item.title,
                style = ComposeTheme.textStyles.base
            )
            Image(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier
                    .rotate(degrees)
                    .size(24.dp),
                colorFilter = ColorFilter.tint(ComposeTheme.colors.gray800)
            )
        }

        if (expanded) {
            when (item.content.type) {
                ContentType.TEXT -> TextContentGrid(item.content.items)
                ContentType.CHECKBOX -> CheckboxContentGrid(item.content.items)
                ContentType.CHIP -> ChipContentGrid(item.content.items)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChipContentGrid(items: List<String>) {
    var selectedChips by remember { mutableStateOf(setOf<String>()) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 300.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            FilterChip(
                selected = item in selectedChips,
                onClick = {
                    selectedChips = if (item in selectedChips) {
                        selectedChips - item
                    } else {
                        selectedChips + item
                    }
                },
                colors = ChipDefaults.filterChipColors(),
                content = { BasicText(item) }
            )
        }
    }
}

@Composable
fun CheckboxContentGrid(items: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 300.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            var checked by remember { mutableStateOf(false) }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it }
                )
                BasicText(
                    text = item,
                    style = ComposeTheme.textStyles.sm
                )
            }
        }
    }
}

@Composable
fun TextContentGrid(items: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 300.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            BasicText(
                text = item,
                style = ComposeTheme.textStyles.sm,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}