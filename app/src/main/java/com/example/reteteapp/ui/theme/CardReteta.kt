package com.example.reteteapp.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.example.reteteapp.data.Reteta
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.ui.draw.clip

@Composable
fun CardReteta(reteta: Reteta) {
    var expanded by remember { mutableStateOf(false) }
    var isPressed by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }


    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            isPressed = interaction is PressInteraction.Press
        }
    }

    val backgroundColor by animateColorAsState(
        targetValue = if (isPressed) Color(0xFFEFDBCD) else MaterialTheme.colorScheme.surface,
        label = "pressColor"
    )


    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(
                onClick = {  },
                onClickLabel = "Selectează rețeta",
                indication = null,
                interactionSource = interactionSource
            ),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Column {
            val showFullImage = false
            Image(
                painter = painterResource(id = reteta.imagineResursa),
                contentDescription = reteta.nume,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f) // sau 4f / 3f dacă preferi mai pătrată
                    .clip(RoundedCornerShape(12.dp)), // opțional pentru colțuri rotunjite
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = reteta.nume,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleSmall,


                )
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = if (expanded) "Ascunde descrierea" else "Afișează descrierea"
                    )
                }
            }
            if (expanded) {
                Text(
                    text = reteta.descriere,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),

                )
            }
        }
    }
}
