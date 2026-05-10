package com.example.a2pexamenjoss.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.a2pexamenjoss.R
import com.example.a2pexamenjoss.data.characterList
import com.example.a2pexamenjoss.model.CharacterItem

// IA generated: Main Home Screen with an improved RPG-style character grid and dynamic UI
@Composable
fun HomeScreen(
    title: String,
    navController: NavController
){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Fondo principal de la aplicación
        Image(
            painter = painterResource(id = R.drawable.main_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // IA generated: Dark overlay to increase readability and depth
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.45f))
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            // Título de la pantalla (consistente con DetailScreen)
            Text(
                text = title,
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(vertical = 32.dp, horizontal = 16.dp),
                textAlign = TextAlign.Center,
                letterSpacing = 1.2.sp
            )

            // Grid de personajes
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(characterList) { character ->
                    CharacterCard(
                        character = character,
                        onClick = { navController.navigate("detail/${character.id}") }
                    )
                }
            }
        }
    }
}

// IA generated: Individual character card with dynamic theme background and perfectly centered image
@Composable
fun CharacterCard(
    character: CharacterItem,
    onClick: () -> Unit
) {
    // IA generated: Assign a unique theme color based on character ID
    val themeColor = when(character.id) {
        1 -> Color(0xFF00E5FF) // Parzival: Cyan
        2 -> Color(0xFFFF4081) // Artemis: Pink
        3 -> Color(0xFFFFD740) // Anorak: Gold
        4 -> Color(0xFF69F0AE) // Sho: Green
        5 -> Color(0xFFFF5252) // Daito: Red
        else -> Color(0xFFB0BEC5) // Others: Gray
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        // IA generated: Dynamic background color based on character's identity using alpha transparency
        colors = CardDefaults.cardColors(
            containerColor = themeColor.copy(alpha = 0.2f)
        ),
        // IA generated: Border stroke to emphasize character theme
        border = androidx.compose.foundation.BorderStroke(
            1.5.dp, 
            themeColor.copy(alpha = 0.5f)
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center, // IA generated: Total vertical centering of the content
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {
            // IA generated: Container with fixed size and Alignment.Center for perfect image centering
            Box(
                modifier = Modifier
                    .size(130.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        Brush.radialGradient(
                            colors = listOf(
                                themeColor.copy(alpha = 0.2f),
                                Color.Transparent
                            )
                        )
                    ),
                contentAlignment = Alignment.Center // Total visual centering
            ) {
                Image(
                    painter = painterResource(character.image),
                    contentDescription = character.name,
                    // IA generated: Centered image with constrained size to prevent visual displacement
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            // Nombre del personaje en mayúsculas para un estilo RPG profesional
            Text(
                text = character.name.uppercase(),
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(top = 16.dp),
                textAlign = TextAlign.Center,
                letterSpacing = 1.sp
            )
            
            // IA generated: Visual decoration line with theme color
            Box(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .widthIn(min = 40.dp)
                    .height(2.5.dp)
                    .clip(RoundedCornerShape(1.dp))
                    .background(themeColor)
            )
        }
    }
}
