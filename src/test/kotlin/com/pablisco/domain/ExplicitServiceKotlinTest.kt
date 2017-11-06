package com.pablisco.domain

import com.pablisco.data.ApiClient
import com.pablisco.domain.ServiceFixtures.*
import com.pablisco.tests.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ExplicitServiceKotlinTest {

    @Test
    fun `should provide name`() {
        val service = Service(stub())

        assertThat(service.name).isEqualTo("Service")
    }

    @Test
    fun `should fetch data from api client`() {
        val service = Service(stub<ApiClient> {
            fetchAll() returns API_DATA
        })

        val items = service.fetchAllItems()

        assertThat(items).containsOnly(ITEM_1, ITEM_2)
    }

    @Test
    fun `should return nothing when api client fails`() {
        val service = Service(stub<ApiClient> {
            fetchAll() throws ::RuntimeException
        })

        val items = service.fetchAllItems()

        assertThat(items).isEmpty()
    }

}