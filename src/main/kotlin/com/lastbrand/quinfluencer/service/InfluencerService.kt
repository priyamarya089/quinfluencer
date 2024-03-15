package com.lastbrand.quinfluencer.service

import com.lastbrand.quinfluencer.domain.Influencer
import com.lastbrand.quinfluencer.repo.InfluencerRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InfluencerService (
    private val influencerRepo: InfluencerRepo
){
    @Transactional
    fun create(influencer: Influencer): Influencer {
        //verify
        //get the data based on insta url
        return influencerRepo.create(influencer)
    }
}