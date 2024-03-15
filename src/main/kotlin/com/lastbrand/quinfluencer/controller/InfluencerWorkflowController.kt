package com.lastbrand.quinfluencer.controller

import com.lastbrand.quinfluencer.domain.Influencer
import com.lastbrand.quinfluencer.service.InfluencerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("influencer")
class InfluencerWorkflowController (
    private val influencerService: InfluencerService
){

    @PostMapping
    fun createInfluencer(@RequestBody influencer: Influencer): {
        return
    }
}