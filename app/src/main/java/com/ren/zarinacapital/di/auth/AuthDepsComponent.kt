package com.ren.zarinacapital.di.auth

import android.content.Context
import com.ren.auth.api.dependencies.AuthDeps
import com.ren.menu.api.dependencies.NewsDeps
import com.ren.common.AppDispatchers
import com.ren.di.scopes.FeatureScope
import com.ren.forexapi.api.apiservice.auth.AuthApiService
import com.ren.presentation.utils.ExceptionMessages
import dagger.BindsInstance
import dagger.Component

@[FeatureScope Component]
interface AuthDepsComponent : AuthDeps {

    override val exceptionMessages: ExceptionMessages
    override val appDispatchers: AppDispatchers
    override val authApiService: AuthApiService

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        @BindsInstance
        fun appDispatchers(appDispatchers: AppDispatchers): Builder

        @BindsInstance
        fun authApiService(authApiService: AuthApiService): Builder

        fun build(): AuthDepsComponent
    }
}