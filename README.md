# Android Java Template

## Purpose

This project is a base template for most of my Java-driven Android applications.

Rather than recreating and configuring again and again I have decided to prepare template that is easily configurable and mostly prepared.

## Compatibility

This application targets Android (5.0) Lollipop and newer.

## Capabilities

1. Model-View-Presenter architectural pattern implemented via Mosby library.
2. Fragment management is simplified by using Fragmentation library.
3. Application is split into tree layers. All implemented in separate modules described below.
4. Data layer is split into three another sub-layers:
    - ***domain*** - only layer that is publicly visible by application layer,
    - ***network*** - exposes networking to domain sub-layer and effectively hides it from application layer,
    - ***persistence*** - exposes database and settings to domain sub-layer and hides it from application layer.  
5. Base activity and fragment classes takes care of releasing reactive disposable added to the disposables bag.
6. Reactive extensions for both Room Persistence and Retrofit allows to easily implement SSOT (Single Source of Truth) pattern.
7. Packaging by feature is favored over packaging by type.
8. Development tools are configurable through `gradle.properties` file.
9. It is expected the dialogs will be created using builder patterns from Material Dialogs library.
10. Mapping between layer models should be done using Model Mapper library.

## Hint

To simplify kick-starting new project and to make life easier when it comes to the need of changing:

- application name,
- module package,
- theme base name,
- style base name.

I've used a keyword `rename` (and `windly.rename` for module).

Just try to search the project for that word and do not hesitate to make required changes.

> Pull Request with Yeoman generator that simplifies generation of the project with configurable name/package is more than greatly appreciated.  

## Project Modules

This particular Android project consists of the following modules:

1. **data** - implements networking, domain and persistence models, converters and managers.
2. **utility** - various utility method such as Debug Bridge, Logger.
3. **application** - produces executable Android application.

## Gradle properties

Available options that can be configured in `gradle.properties` file:

  - `EnableBugTracker` - allows to enable/disable default bugtracker (eg. Crashlytics),
  - `EnableDebugBridge` - allows to enable/disable debug bridge (eg. Stetho).

> Note that you can find `gradle.properties.sample` file in application modules. If you would like to use default values, just copy this file and paste as `gradle.properties`.

> File `gradle.properties` is not tracked by git so you can use sensitive data there - but use it with care!  

After preparing `gradle.properties` file you have to synchronize your Gradle build. This allows to generate `BuildConfig` class with required constant variables.
