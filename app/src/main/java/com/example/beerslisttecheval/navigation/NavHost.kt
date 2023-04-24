import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.beerslisttecheval.navigation.Screen
import com.example.beerslisttecheval.ui.beerdetails.BeerDetailsScreen
import com.example.beerslisttecheval.ui.beerlist.BeerScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppNavigation(){

    val navController = rememberNavController()
    val targetScreen = rememberSaveable { mutableStateOf(Screen.BeerList) }

    Scaffold(
        topBar = { Toolbar(targetScreen = targetScreen.value, navController = navController) }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.BeerList.route
            ) {
            composable(Screen.BeerList.route) {
                targetScreen.value = Screen.BeerList
                BeerScreen(navController = navController)
            }
            composable("${Screen.Details.route}/{beerId}") { backStackEntry ->
                targetScreen.value = Screen.Details
                BeerDetailsScreen(
                    backStackEntry.arguments?.getString("beerId")!!.toInt()
                )
            }
        }
    }

}

@Composable
fun Toolbar(
    targetScreen: Screen,
    navController: NavController
){
    if (targetScreen != Screen.BeerList) {
        TopAppBar(
            title = { Text(text = targetScreen.header, color = Color.White) },
            navigationIcon = { BackButton(navController = navController) },
            backgroundColor = Color(0xFF6F7FF7)
        )
    } else {
        TopAppBar(
            title = { Text(text = targetScreen.header, color = Color.White) },
            backgroundColor = Color(0xFF6F7FF7)
        )
    }
}

@Composable
fun BackButton(navController: NavController) {
    IconButton(onClick = { navController.popBackStack() }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back",
            tint = Color.White
        )
    }
}