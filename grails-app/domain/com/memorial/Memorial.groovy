package com.memorial

import com.sun.jmx.snmp.Timestamp

class Memorial {

     Long id
     Long version

     String memorialName
     String memorialDescription
     String memorialCreateUser
     String memorialUpdateUser
     String memorialLocation

     Boolean memorialActive

     Date memorialStartDate
     Date memorialEndDate
     Timestamp memorialCreateTimestamp
     Timestamp memorrialUpdateTimestamp

     static relateToMany =  [victims:Victim]
     Set victims = new HashSet()

    static constraints = {
        memorialName(nullable:false,blank:false,unique:true, size:1..1000)
        memorialDescription(nullable:true, blank:true, size:1..4000)
        memorialCreateUser(nullable:false, blank:false, size:1..1000)
        memorialUpdateUser(nullable:false, blank:false, size:1..1000)
        memorialLocation(nullable:false, blank:false, size:1..1000)
        memorialActive(nullable:false)
        memorialStartDate(date:true)
        memorialEndDate(date:true)
        memorialCreateTimestamp(timestamp:false)
        memorrialUpdateTimestamp(timestamp:false)
        //victims()
    }
}
