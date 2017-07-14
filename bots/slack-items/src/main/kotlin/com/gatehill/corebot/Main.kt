package com.gatehill.corebot

import com.gatehill.corebot.action.OperationFactoryConverter
import com.gatehill.corebot.action.NoOpOperationFactoryConverter
import com.gatehill.corebot.driver.items.ItemsDriverModule
import com.google.inject.AbstractModule

fun main(args: Array<String>) {
    Bot.build(BotModule(), SlackModule()).start()
}

private class BotModule : AbstractModule() {
    override fun configure() {
        bind(BotBootstrap::class.java).asEagerSingleton()
        bind(OperationFactoryConverter::class.java).to(NoOpOperationFactoryConverter::class.java).asSingleton()

        // drivers
        install(ItemsDriverModule())
    }
}
