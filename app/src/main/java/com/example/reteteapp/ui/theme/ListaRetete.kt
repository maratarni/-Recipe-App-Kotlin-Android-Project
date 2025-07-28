package com.example.reteteapp.ui.theme



import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.reteteapp.data.listaRetete
import com.example.reteteapp.ui.CardReteta

@Composable
fun ListaRetete(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(listaRetete) { reteta ->
            CardReteta(reteta)
        }
    }
}