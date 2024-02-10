package com.gabrielcastro.practicaandroidsuperpoderes.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.gabrielcastro.practicaandroidsuperpoderes.data.local.SuperHeroLocal

@Composable
fun SuperHeroListScreen (viewModel: HeroViewModel, onHeroClick3: (Long) -> Unit) {

    val heroListState by viewModel.heroListState.collectAsState()
    val favCount by viewModel.favCountState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getHeroes5()
    }

    SuperHeroListScreenContent(heroListState, favCount) { id ->
        onHeroClick3(id)
    }
}

@Preview(showBackground = true)
@Composable
fun SuperHeroListScreen_Preview() {
    SuperHeroListScreenContent(heroesSample,0) { }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroListScreenContent(heroes: List<SuperHeroLocal>, favs: Int, onHeroClick2: (Long) -> Unit) {

    val scaffoldS = rememberScaffoldState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ListTopBar(favs)
        },
//        bottomBar = {
//            ListBottomBar()
//        }
    ) {
        LazyColumn(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp), contentPadding = it) {
            items(heroes, key = { it.id }) { hero ->
                SuperHeroItem(hero = hero, onHeroClick1 = onHeroClick2)
            }
        }
    }
}

@Composable
fun SuperHeroItem(hero: SuperHeroLocal, modifier: Modifier = Modifier, onHeroClick1: (Long) -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
            .clickable { onHeroClick1(hero.id) }
    ) {
        AsyncImage(
            model = hero.photo,
            contentDescription = hero.description,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentScale = ContentScale.Crop
        )
        LazyRow(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            item {
                Text(text = hero.name, style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(8.dp))
            }
            item {
                val onFavClick2: (SuperHeroLocal) -> Unit = {}
                FavoriteHeart(hero = hero, onFavClick1 = onFavClick2)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SuperHeroItem_Preview() {
    SuperHeroItem(
        SuperHeroLocal(
            123,
            "Thor",
            "http://i.annihil.us/u/prod/marvel/i/mg/d/d0/5269657a74350.jpg",
            "God of Lightening...",
            favorite = false
        )) { }
}

// TopBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListTopBar(favs: Int = 0) {

    CenterAlignedTopAppBar(title = {
        Text(text = "Marvel Super Heroes", style = androidx.compose.material3.MaterialTheme.typography.titleLarge, modifier = Modifier.padding(8.dp)
        )
    })
}

// BottomBar
@Composable
fun ListBottomBar(favs: Int = 0) {
    BottomAppBar() {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            BottomBarItem(text = "Home", icon = Icons.Default.Home)
            BottomBarItem(text = "Favs ($favs)", icon = Icons.Default.Favorite)
        }
    }
}

@Preview
@Composable
fun ListTopBar_Preview() {
    ListTopBar()
}

@Preview
@Composable
fun MyBottomBar_Preview() {
    ListBottomBar()
}

@Composable
fun BottomBarItem(text: String, icon: ImageVector) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(imageVector = icon, contentDescription = icon.name)
        Text(text = text)
    }
}

@Preview
@Composable
fun BottomBarItem_Preview() {
    BottomBarItem(text = "Home", icon = Icons.Default.Home)
}

val heroesSample = listOf(
    SuperHeroLocal(
        id = 1009664,
        name = "Thor",
        photo = "http://i.annihil.us/u/prod/marvel/i/mg/d/d0/5269657a74350.jpg",
        description = "God of lightning",
        favorite = false
    ),
    SuperHeroLocal(
        id = 1009368,
        name = "Iron Man",
        photo = "http://i.annihil.us/u/prod/marvel/i/mg/9/c0/527bb7b37ff55.jpg",
        description = "Billionaire, genius, industrialist",
        favorite = false
    ),
    SuperHeroLocal(
        id = 1009282,
        name = "Doctor Strange",
        photo = "http://i.annihil.us/u/prod/marvel/i/mg/5/f0/5261a85a501fe.jpg",
        description = "Genius magician",
        favorite = false
    )
)