node("10.0.0.5") {
    timeout(unit: 'SECONDS', time: 5) {
        stage("One"){
            sleep 10
            sh 'mvn -B -DskipTests clean package'
        }
    }
}