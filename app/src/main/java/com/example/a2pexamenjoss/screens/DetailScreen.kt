package com.example.a2pexamenjoss.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a2pexamenjoss.data.characterList

// IA generated: Enhanced RPG Character Detail Screen with dynamic card design and stats
@Composable
fun DetailScreen(
    title: String,
    navController: NavController,
    characterId: Int
) {
    val character = characterList.first { it.id == characterId }
    val scrollState = rememberScrollState()
    var isHover by remember { mutableStateOf(false) }

    // IA generated: Procedural RPG stats for visual variety
    val strength = remember { ((characterId * 17 + 45) % 100) / 100f }
    val agility = remember { ((characterId * 23 + 35) % 100) / 100f }
    val damage = remember { ((characterId * 13 + 60) % 100) / 100f }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Fondo dinámico basado en el personaje
        Image(
            painter = painterResource(character.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // IA generated: Gradient overlay to make the UI pop and improve text contrast
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.3f),
                            Color.Black.copy(alpha = 0.85f)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 1. TÍTULO PRINCIPAL (Igual que en HomeScreen)
            // IA generated: Consistent header title
            Text(
                text = title,
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp),
                textAlign = TextAlign.Center
            )

            // 2. ESTRUCTURA GENERAL - PANEL RPG
            // IA generated: Main character card with glassmorphism-style translucency
            Card(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black.copy(alpha = 0.65f)
                ),
                shape = RoundedCornerShape(24.dp),
                border = androidx.compose.foundation.BorderStroke(
                    1.dp, 
                    Color.White.copy(alpha = 0.15f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Nombre del Personaje con estilo futurista
                    Text(
                        text = character.name.uppercase(),
                        color = Color(0xFF00E5FF),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 2.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // 3. IMAGEN DEL PERSONAJE (Hero Section)
                    // IA generated: Hero section with interaction indicator
                    Box(
                        contentAlignment = Alignment.BottomEnd,
                        modifier = Modifier
                            .size(280.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White.copy(alpha = 0.03f))
                            .clickable { isHover = !isHover }
                    ) {
                        Image(
                            painter = painterResource(
                                if (isHover) character.hoverImage else character.image
                            ),
                            contentDescription = character.name,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Fit
                        )
                        
                        // IA generated: "TAP" indicator to signal interactivity
                        Box(
                            modifier = Modifier
                                .padding(12.dp)
                                .background(Color.Black.copy(alpha = 0.7f), RoundedCornerShape(8.dp))
                                .padding(horizontal = 10.dp, vertical = 5.dp),
                            contentAlignment = Alignment.Center
                        ) {
                             Text("TAP", color = Color(0xFF00E5FF), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    // 4. DESCRIPCIÓN DEL PERSONAJE
                    // IA generated: Lore box with balanced padding
                    Surface(
                        color = Color.White.copy(alpha = 0.07f),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = character.description,
                            color = Color.White.copy(alpha = 0.85f),
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    // 5. STATS TIPO RPG
                    // IA generated: RPG Stats section with modern progress bars
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        StatBar(label = "FUERZA", value = strength, color = Color(0xFFFF5252))
                        StatBar(label = "AGILIDAD", value = agility, color = Color(0xFF69F0AE))
                        StatBar(label = "DAÑO", value = damage, color = Color(0xFFFFD740))
                    }
                    
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            
            // Spacer for bottom content
            Spacer(modifier = Modifier.height(100.dp))
        }

        // IA generated: Floating action button for navigation
        FloatingActionButton(
            onClick = { navController.popBackStack() },
            containerColor = Color(0xFF00E5FF),
            contentColor = Color.Black,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }
    }
}

// IA generated: Reusable component for RPG stats bars
@Composable
fun StatBar(label: String, value: Float, color: Color) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label, 
                color = Color.Gray, 
                fontSize = 12.sp, 
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.2.sp
            )
            Text(
                text = "${(value * 100).toInt()}%",
                color = color, 
                fontSize = 13.sp, 
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        // IA generated: Using the modern non-deprecated version of progress indicator
        LinearProgressIndicator(
            progress = { value },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = color,
            trackColor = Color.White.copy(alpha = 0.1f)
        )
    }
}
