package dika.vasscom.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dika.vasscom.App.Companion.allModules
import dika.vasscom.ui.components.AppFooter
import dika.vasscom.ui.components.AppSpacer
import dika.vasscom.ui.components.AppTextButton
import dika.vasscom.ui.components.AppTextLite
import dika.vasscom.ui.components.BannerService
import dika.vasscom.ui.components.LoadingDialog
import dika.vasscom.ui.components.Tips
import dika.vasscom.ui.components.TopBar
import dika.vasscom.ui.screens.home.component.AppDrawer
import dika.vasscom.ui.screens.home.component.FilterOption
import dika.vasscom.ui.screens.home.component.ListBanner
import dika.vasscom.ui.screens.home.component.ListServices
import dika.vasscom.ui.screens.home.component.ListTools
import dika.vasscom.ui.screens.home.component.SearchFilter
import dika.vasscom.ui.theme.VascommHospitalTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinApplication

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = koinViewModel()
    val currentState by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getData()
    }

    val isLoading = currentState is HomeState.Loading
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                drawerState = drawerState,
                navigateToProfile = {  },
                navigateToSetting = {},
                navigateToLogin = { },
                onCloseTap = { scope.launch { drawerState.close() }}
            )
        },
        gesturesEnabled = false
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Scaffold(
                topBar = {
                    TopBar(
                        onRefreshClick = { viewModel.getData() },
                        onMenuClick = { scope.launch {
                            drawerState.open()
                        }}
                    )
                }
            ) { paddingValues ->
                when (currentState) {
                    is HomeState.Idle, is HomeState.Loading -> {
                        EmptyHomeContent(paddingValues)
                    }
                    is HomeState.ShowData -> {
                        val showDataState = currentState as HomeState.ShowData
                        SuccessHomeContent(
                            paddingValues = paddingValues,
                            tips = showDataState.tips,
                            banners = showDataState.banners,
                            onTipClick = { tip ->
                                Log.d("HomeScreen", "Tip clicked: $tip")
                            }
                        )
                    }
                    is HomeState.Error -> {
                        val errorState = currentState as HomeState.Error
                        ErrorHomeContent(
                            paddingValues = paddingValues,
                            errorMessage = errorState.message,
                            onRetry = { viewModel.getData() }
                        )
                    }
                }
            }
            LoadingDialog(isLoading = isLoading)
        }
    }
}

@Composable
private fun SuccessHomeContent(
    paddingValues: androidx.compose.foundation.layout.PaddingValues,
    tips: List<Tips>,
    banners: List<BannerService>,
    onTipClick: (Tips) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(color = Color.White)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ListBanner(
                tips = tips,
                bannerServices = banners,
                onClick = { item ->
                    when (item) {
                        is Tips -> onTipClick(item)
                        is BannerService -> {
                            Log.d("HomeScreen", "Banner clicked: ${item.title}")
                            // Handle banner click if needed
                        }
                    }
                }
            )
            SearchFilter()
            FilterOption()
            ListTools()
            ListServices()
        }
        AppSpacer(20)
        AppFooter()
    }
}

@Composable
private fun EmptyHomeContent(paddingValues: androidx.compose.foundation.layout.PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(color = Color.White)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(modifier = Modifier.weight(1f)) {}
        AppFooter()
    }
}

@Composable
private fun ErrorHomeContent(
    paddingValues: androidx.compose.foundation.layout.PaddingValues,
    errorMessage: String,
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(color = Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        AppTextLite(
            text = "Error: $errorMessage",
            size = 20
        )
        AppTextButton(
            title = "Retry",
            icon = Icons.Default.Refresh,
            onClick = onRetry
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    VascommHospitalTheme {
        KoinApplication(application = {
            allModules()
        }) {
            HomeScreen()
        }
    }
}