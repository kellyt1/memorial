package myapp

import com.memorial.Memorial
import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)

//        GrailsApp.gorm.default.constraints = {
//            myShared(nullable:false, blank:false, size:1..1000)
//        }

//        GrailsApp.validateable.classes = [Memorial]
    }


}