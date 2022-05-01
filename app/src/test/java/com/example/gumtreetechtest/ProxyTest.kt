package com.example.gumtreetechtest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.gumtreetechtest.api.CarsApi
import com.example.gumtreetechtest.domain.ApiResults
import com.example.gumtreetechtest.domain.CarsRepository
import com.example.gumtreetechtest.domain.CarsRepositoryImpl
import com.example.gumtreetechtest.domain.SearchResults
import com.example.gumtreetechtest.network.Result
import com.example.gumtreetechtest.proxy.CarsProxy
import com.example.gumtreetechtest.proxy.CarsProxyImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class ProxyTest {

    @RelaxedMockK
    private lateinit var api: CarsApi

    private lateinit var proxy: CarsProxy

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        proxy = CarsProxyImpl(api)

        val data = TestUtils.listOfSearchResults
        coEvery { api.fetchCars(any(), any(), any()) } returns ApiResults(searchResults = data)
    }

    @Test
    fun proxyFetchCars_callsApiFetchcars() = runTest {
        this.launch {
            proxy.fetchCars("","","")
            coVerify { api.fetchCars(any(), any(), any()) }
        }
    }

    @Test
    fun convertsToSuccessResultsObject_whenApiResponseIsSuccess() = runTest {
        this.launch {
            val successfulSearchResult = proxy.fetchCars("","","")
            assert(successfulSearchResult is Result.Success)
        }
    }

    @Test
    fun convertsToErrorResultsObject_whenApiResponseReturnsApiResultsWithNull() = runTest {
        coEvery { api.fetchCars(any(), any(), any()) } returns ApiResults(searchResults = null)
        this.launch {
            val successfulSearchResult = proxy.fetchCars("","","")
            assert(successfulSearchResult is Result.Error)
        }
    }

    @Test
    fun convertsToErrorResultsObject_whenApiResponseReturnsNull() = runTest {
        coEvery { api.fetchCars(any(), any(), any()) } returns null
        this.launch {
            val errorSearchResult = proxy.fetchCars("","","")
            assert(errorSearchResult is Result.Error)
        }
    }


}


