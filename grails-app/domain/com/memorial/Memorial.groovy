package com.memorial

import com.sun.jmx.snmp.Timestamp
import jdk.nashorn.internal.objects.annotations.Property

class Memorial {

    @Property Long id
    @Property Long version

    @Property String memorialName
    @Property String memorialDescription
    @Property String memorialCreateUser
    @Property String memorialUpdateUser
    @Property String memorialLocation

    @Property Boolean memorialActive

    @Property Date memorialStartDate
    @Property Date memorialEndDate
    @Property Timestamp memorialCreateTimestamp
    @Property Timestamp memorrialUpdateTimestamp

    @Property relatesToMany =  [Victim:victims]
    @Property Set victims = new HashSet()

    static constraints = {
        memorialName(nullable:false,blank:false,unique:true, size:1..1000)
        memorialDescription(nullable:true, blank:true, size:1..4000)
        memorialCreateUser(nullable:false, blank:false, size:1..1000)
        memorialUpdateUser(nullable:false, blank:false, size:1..1000)
        memorialLocation(nullable:false, blank:false, size:1..1000)
        memorialActive(nullable:false)
        memorialStartDate(date:true)
        memorialEndDate(date:true)
        memorialCreateTimestamp(timestamp:true)
        memorrialUpdateTimestamp(timestamp:true)
        //victims()
    }
}
