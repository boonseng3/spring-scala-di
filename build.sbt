name := "Spring scala DI"

version := "0.1"

scalaVersion := "2.11.4"

libraryDependencies ++= {
  Seq(
     "org.springframework.scala"    % "spring-scala_2.10"         % "1.0.0.RC1"
  )  
}

EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.Unmanaged, EclipseCreateSrc.Source, EclipseCreateSrc.Resource)

EclipseKeys.withSource := false

resolvers += "Spring Dependencies" at "http://repo.springsource.org/libs-milestone" 