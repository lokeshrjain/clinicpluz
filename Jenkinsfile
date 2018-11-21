pipeline {
  agent any
  tools {
    maven 'M3.6.0'
  }
  stages{
  	stage('Build and Test') {
  	  steps {
  	   sh 'ls'
  	   sh 'mvn --version'
       sh 'mvn clean install'
      }
  	}
  }
}