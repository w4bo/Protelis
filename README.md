# PROTELIS

Java-hosted execution of Protelis programs.

## Usage

### Prerequisites

Protelis requires Java 7+ in order to run.


### Using Protelis in your project

We suggest using Gradle, Maven or a similar system to deal with dependencies within your project. In this case, you can use Protelis (and all of its dependencies) by importing the following Maven dependency:

```xml
<dependency>
    <groupId>org.protelis</groupId>
    <artifactId>protelis</artifactId>
    <version>VERSION_YOU_WANT_TO_USE</version>
</dependency>
```

or the following Gradle dependency:

```Gradle
compile 'org.protelis:protelis:VERSION_YOU_WANT_TO_USE'
```

Alternatively, you can download the latest jar and place it in your classpath. In this case, be sure to include the dependencies of this project in your classpath.

### Eclipse plug-in

An Eclipse plug-in is available for easing the code writing. To install it, select the "Install new software" option of Eclipse, and paste as repository URL the following address: `http://efesto.apice.unibo.it/protelis-build/protelis-parser/protelis.parser.repository/target/repository/`. Install the proposed software and restart the IDE. When asked if you want to add the "Xtext nature" to your project, answer "Yes". You should be now able to use code highlighting and auto-completion on any `.pt` file.

### Javadoc

Javadoc is available [here][Javadoc]. This documentation is generated by our nightly build system, so it may be up to 24 hours out of date (assuming the build is passing).
The documentation for any specific version of this library is released on Maven Central along with the code and the compiled jar file.


### Downloads

The latest _stable_ artifacts for this project can be downloaded [here][Jars]. This page includes three artifacts:
* A jar file containing the compiled class files
* A jar file containing the source code
* A jar file containing the generated javadoc

Complete build reports can be downloaded [here][reports]


## Build Status
[![Build Status](https://drone.io/github.com/Protelis/Protelis/status.png)](https://drone.io/github.com/Protelis/Protelis/latest)


### Main project
* [Build reports][dashboard]
* [Test summary][test]
* [FindBugs violations][findbugs]
* [PMD violations][pmd]
* [Checkstyle violations][checkstyle]


### Tests
* [FindBugs violations][findbugs-test]
* [PMD violations][pmd-test]
* [Checkstyle violations][checkstyle-test]


## Notes for Developers


### Importing the project
The project has been developed using Eclipse, and can be easily imported in such IDE.


#### Recommended configuration
* Download [the latest Eclipse for Java SE developers][eclipse]. Arch Linux users can use the package extra/eclipse-java, which is rather up-to-date.
  * The minimum version required for a smooth import is Eclipse Mars.1, which integrates Gradle Buildship
  * Previous Eclipse versions are okay, provided that the Gradle Buildship plugin is installed
* Install the code quality plugins:
  * In Eclipse, click Help -> Eclipse Marketplace...
  * In the search form enter "findbugs", then press Enter
  * One of the retrieved entries should be "FindBugs Eclipse Plugin", click Install
  * Click "< Install More"
  * In the search form enter "checkstyle", then press Enter
  * One of the retrieved entries should be "Checkstyle Plug-in" with a written icon whose text is "eclipse-cs", click Install
  * Click "Install Now >"
  * Wait for Eclipse to resolve all the features
  * Click "Confirm >"
  * Follow the instructions, accept the license, wait for Eclipse to download and install the product, accept the installation and restart the IDE.
  * PMD must be installed directly from the official update site. Click "Help", then "Install new software".
  * In the URL bar, paste `https://sourceforge.net/projects/pmd/files/pmd-eclipse/update-site/`
  * Press enter
  * Select PMD for Eclipse 4
  * Follow the instructions, accept the license, wait for Eclipse to download and install the product, accept the installation and restart the IDE.
* Set the line delimiter to LF (only for **Windows users**)
  * In Eclipse, click window -> preferences
  * In the search form enter "encoding", then press Enter
  * Go to General -> Workspace
  * In the section "New text file line delimiter" check "Other" and choose Unix
  * Apply
* Use space instead of tabs
  * In Eclipse, click window -> preferences
  * Go to General -> Editors -> Text Editors
  * Check "insert spaces for tabs" option.
  * Apply.
  * Go to Java -> Code style -> Formatter
  * Click Edit button
  * In Indentation tab, under "General Settings", set "tab policy" to "Spaces only"
  * Apply (you should probably rename the formatter settings).

#### Import Procedure
* Install git on your system, if you haven't yet
* Pull up a terminal, and `cd` to the folder where you want the project to be cloned (presumably, your Eclipse workspace)
* Clone the project with `git clone git@github.com:Protelis/Protelis.git`
  * If you are a Windows user, you might find easier to import via HTTPS: `git clone https://github.com/Protelis/Protelis.git`
* Click File -> Import -> Gradle -> Gradle Project -> Next
* Select the project root directory.
* Next
* Make sure that "Gradle wrapper (recommended)" is selected
* Next
* Wait for Eclipse to scan the project.
* Finish
* When (and if) asked about the existing Eclipse configuration, select "Keep" (so that all the default development options are imported)
* The projects will appear in your projects list.
* Checkstyle, PMD and FindBugs should be pre-configured.
* If you get errors due to missing dependencies, right click on the project, select Gradle -> Refresh Gradle Project.

### Developing the project
Contributions to this project are welcome.  To ensure that your contribution is incorporated quickly, we request that you follow the following coding best practices:

0. We use [git flow](https://github.com/nvie/gitflow), so if you write new features, please do so in a separate `feature-` branch.
0. We recommend forking the project, developing your stuff, then contributing back via pull request directly from GitHub
0. Commit often. Do not send pull requests with a single giant commit adding or changing the massive amounts at once, as this is likely to have conflicts with other work. Split it in multiple commits and request a merge to the main line often.
0. Do not introduce low quality code. All new code should comply with checker rules (which are quite strict) and should not introduce other warnings. Resolution of existing warnings (if any are currently present) is very welcome.


#### Building the project
While developing, you can rely on Eclipse to build the project, it will generally do a very good job.
If you want to generate the artifacts, you can rely on Gradle. Just point a terminal on the project's root and issue

```bash
./gradlew
```

This will trigger the creation of the artifacts the executions of the tests, the generation of the documentation and of the project reports.

#### Testing protelis-lang
Though `protelis-lang` requires Java 1.7, running its tests **from Eclipse** requires Java 1.8.

* Change `JavaSE-1.7` to `JavaSE-1.8` in `protelis-lang/.classhpath`
* **Do not** commit this update.

#### Release numbers explained
We release often. We are not scared of high version numbers, as they are just numbers in the end.
We use a three level numbering, following the model of [Semantic Versioning][SemVer]:

* **Update of the minor number**: there are some small changes, and no backwards compatibility is broken. More particularly, it should be the case that any project that depends on this one should have no problem compiling or running. Raise the minor version if there is just a bug fix or a code improvement, such that no interface, constructor, or non-private member of a class is modified either in syntax or in semantics. Also, no new classes should be provided.
	* Example: switch from 1.2.3 to 1.2.4 after improving how an error condition is reported 
* **Update of the middle number**: there are changes that should not break any backwards compatibility, but the possibility exists. Raise the middle version number if there is a remote probability that projects that depend upon this one may have problems compiling if they update. For instance, if you have added a new class, since a depending project may have already defined it, that is enough to trigger a mid-number change. Also updating the version ranges of a dependency, or adding a new dependency, should cause the mid-number to raise. As for minor numbers, no changes to interfaces, constructors or non-private member of classes are allowed, except for adding *new* methods. If mid-number is update, minor number should be reset to 0.
	* Example: switch from 1.2.3 to 1.3.0 after adding new methods for computing with Tuples.
* **Update of the major number**: *non-backwards-compatible change*. If a change in interfaces, constructors, or public member of some class has happened, a new major number should be issued. This is also the case if the semantics of some method has changed. In general, if there is a high probability that projects depending upon this one may experience compile-time or run-time issues if they switch to the new version, then a new major number should be adopted. If the major version number is upgraded, the mid and minor numbers should be reset to 0.
	* Example: switch from 1.2.3 to 2.0.0 after changing the interface for parsing programs.


[Javadoc]: http://protelis-doc.surge.sh/
[Jars]: http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22protelis%22
[reports]: https://drone.io/github.com/Protelis/Protelis/files/build/reports/reports.tar
[dashboard]: http://137.204.107.70/protelis-build/protelis/build/reports/buildDashboard/
[test]: http://137.204.107.70/protelis-build/protelis/build/reports/tests/
[checkstyle]: http://137.204.107.70/protelis-build/protelis/build/reports/checkstyle/main.html
[checkstyle-test]: http://137.204.107.70/protelis-build/protelis/build/reports/checkstyle/test.html
[findbugs]: http://137.204.107.70/protelis-build/protelis/build/reports/findbugs/main.html
[findbugs-test]: http://137.204.107.70/protelis-build/protelis/build/reports/findbugs/test.html
[pmd]: http://137.204.107.70/protelis-build/protelis/build/reports/pmd/main.html
[pmd-test]: http://137.204.107.70/protelis-build/protelis/build/reports/pmd/test.html
[eclipse]: https://eclipse.org/downloads/
[SemVer]: http://semver.org/spec/v2.0.0.html
