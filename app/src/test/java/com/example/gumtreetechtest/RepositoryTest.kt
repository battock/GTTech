package com.example.gumtreetechtest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.gumtreetechtest.domain.CarsRepository
import com.example.gumtreetechtest.domain.CarsRepositoryImpl
import com.example.gumtreetechtest.network.Result
import com.example.gumtreetechtest.proxy.CarsProxy
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
class RepositoryTest {

    @RelaxedMockK
    private lateinit var proxy: CarsProxy

    private lateinit var repository: CarsRepository

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        repository = CarsRepositoryImpl(proxy)

        val data = TestUtils.listOfCars
        coEvery { proxy.fetchCars(any(), any(), any()) } returns Result.Success(data)
    }

    @Test
    fun repositoryFetchCars_callsProxyFetchcars() = runTest {
        this.launch {
            repository.fetchCars("","","")
            coVerify { proxy.fetchCars(any(), any(), any()) }
        }
    }

}


