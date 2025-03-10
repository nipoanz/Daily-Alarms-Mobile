package com.miso.dailyalarms.ui

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.miso.dailyalarms.R
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavHostController
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.miso.dailyalarms.ui.screens.ForgotPasswordScreen
import com.miso.dailyalarms.ui.screens.GroupListScreen
import com.miso.dailyalarms.ui.screens.LoginScreen
import com.miso.dailyalarms.ui.screens.SignUpScreen


/**
 * enum values that represent the screens in the app
 */
enum class DailyAlarmsScreen(val route: String) {
    GroupsList(route = "group_list"),
    Login(route = "login"),
    SignUp(route = "sign_up"),
    ForgotPasswrod(route = "forgot_password"),
}


@Composable
fun DailyAlarmsApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        content = { innerPadding -> Navigation(navController, innerPadding) }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyAlarmsAppBar(
    modifier: Modifier = Modifier,
    isVisible: Boolean = false,
    navigateUp: () -> Unit,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(initialOffsetY = { fullHeight -> -fullHeight }) + fadeIn(),
        exit = slideOutVertically(targetOffsetY = { fullHeight -> -fullHeight }) + fadeOut(),
        content = {
            //CenterAlignedTopAppBar
            TopAppBar(
                title = { stringResource(R.string.app_name) },
                scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
                    rememberTopAppBarState()
                ),
                modifier = modifier,
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.regresar_boton_descripcion)
                        )
                    }
                }
            )
        }
    )
}

@Composable
fun Navigation(
    navController: NavHostController,
    innerPadding: PaddingValues = PaddingValues()
)
{
    val tweenSpec: FiniteAnimationSpec<IntOffset> = tween(300, 0, EaseOut)
    NavHost(
        navController = navController,
        startDestination = DailyAlarmsScreen.Login.route,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Start,
                tweenSpec
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Start,
                tweenSpec
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.End,
                tweenSpec
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.End,
                tweenSpec
            )
        }
    ) {
        composable(DailyAlarmsScreen.GroupsList.route) {
            GroupListScreen(navController)
        }
        composable(DailyAlarmsScreen.Login.route) {
            LoginScreen(navController)
        }
        composable(DailyAlarmsScreen.SignUp.route) {
            SignUpScreen(navController)
        }
        composable(DailyAlarmsScreen.ForgotPasswrod.route) {
            ForgotPasswordScreen(navController)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    AppTheme(darkTheme = false) {
        Navigation(rememberNavController())
    }
}