pipeline {
        agent none
        stages {
          stage("build & SonarQube analysis") {
            agent {
                label '10.0.0.5'
            } 
            steps {
              withSonarQubeEnv('SonarQube') {
                sh 'mvn clean package'
              }
            }
          }
          //stage("Quality Gate") {
            //steps {
              //timeout(time: 1, unit: 'HOURS') {
                //waitForQualityGate abortPipeline: true
              }
            }
          }
        }
      }