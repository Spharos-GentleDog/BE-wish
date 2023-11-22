pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh '''
                    chmod +x gradlew
                    ./gradlew build -x test
                '''
            }
        }
        stage('DockerSize') {
            steps {
                sh '''
                    docker stop wish || true
                    docker rm wish || true
                    docker rmi wish || true
                    docker build -t wish .
                    echo "wish: build wish"
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh '''
                docker run -e EUREKA_URL="${EUREKA_URL}" -e MASTER_DB_URL="${MASTER_DB_URL}/wish" -e MASTER_DB_USERNAME="${MASTER_DB_USERNAME}" -e MASTER_DB_PASSWORD="${MASTER_DB_PASSWORD}" -e BOOTSTRAP_SERVERS="${BOOTSTRAP_SERVERS}" -d --name wish --network gentledog wish
                echo "wish: run success"
                '''
                }
        }
    }
}
