pipeline {
        agent any
        stages {
          stage("build & SonarQube analysis") {
            agent {
                label '10.0.0.5'
            } 
            steps {
              withSonarQubeEnv('SonarQube') {
                sh 'sonar-scanner'
              }
            }
          }
          stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
          }
        }
      }