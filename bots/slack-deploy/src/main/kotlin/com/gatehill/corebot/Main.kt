package com.gatehill.corebot

import com.gatehill.corebot.action.OperationFactoryConverter
import com.gatehill.corebot.driver.jenkins.JenkinsDriverModule
import com.gatehill.corebot.driver.jobs.JobsDriverModule
import com.gatehill.corebot.driver.jobs.action.TriggerOperationFactoryConverter
import com.gatehill.corebot.driver.rundeck.RundeckDriverModule
import com.google.inject.AbstractModule

fun main(args: Array<String>) {
    Bot.build(BotModule(), SlackModule()).start()
}

private class BotModule : AbstractModule() {
    override fun configure() {
        bind(BotBootstrap::class.java).asEagerSingleton()
        bind(OperationFactoryConverter::class.java).to(TriggerOperationFactoryConverter::class.java).asSingleton()

        // drivers
        install(JobsDriverModule())
        install(JenkinsDriverModule())
        install(RundeckDriverModule())
    }
}
