package com.pablisco.domain

import com.pablisco.data.ApiClient
import com.pablisco.domain.ServiceFixtures.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit

class AutoInjectServiceKotlinTest {

    @Suppress("unused")
    @get:Rule
    val mockitoRule = MockitoJUnit.rule()!!

    @Mock
    private lateinit var apiClient: ApiClient

    private lateinit var service: Service

    @Before
    fun setUp() {
        service = Service(apiClient)
    }

    @Test
    fun `should provide name`() {
        val name = service.name

        assertThat(name).isEqualTo("Service")
    }

    @Test
    fun `should fetch data from api client`() {
        given(apiClient.fetchAll()).willReturn(API_DATA)

        val items = service.fetchAllItems()

        assertThat(items).containsOnly(ITEM_1, ITEM_2)
    }

    @Test
    fun `should return nothing when api client fails`() {
        given(apiClient.fetchAll()).willThrow(RuntimeException::class.java)

        val items = service.fetchAllItems()

        assertThat(items).isEmpty()
    }
}