@echo off
SET ENV=%1

IF "%ENV%"=="" (
    echo No environment specified!
    echo Usage: deploy.bat [dev|qa|prod]
    exit /b 1
)

echo ===== Deploying to %ENV% Environment =====

:: Example: Copy build artifacts
xcopy /Y /E "%WORKSPACE%\target" "C:\deployments\%ENV%"

:: Example: Restart service (optional, change service name per env if needed)
net stop MyAppService
net start MyAppService

echo ===== Deployment to %ENV% Completed Successfully =====
exit /b 0
