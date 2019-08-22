# obs
Obs full
//Carsh Screen
ObConfig =>

//Permission
PermissionManager.handleResult(this, requestCode, permissions, grantResults);

PermissionManager.Builder()
                        .key(2100)
                        .permission(PermissionEnum.GET_ACCOUNTS, PermissionEnum.ACCESS_FINE_LOCATION, PermissionEnum.READ_SMS)
                        .askAgain(true)
                        .askAgainCallback(new AskAgainCallback() {
                            @Override
                            public void showRequestPermission(UserResponse response) {
                                showDialog(response);
                            }
                        })
                        .callback(new SmartCallback() {
                            @Override
                            public void result(boolean allPermissionsGranted, boolean somePermissionsDeniedForever) {
                                Toast.makeText(MainActivity.this, PermissionEnum.GET_ACCOUNTS.toString() + ", " + PermissionEnum.ACCESS_FINE_LOCATION.toString() + ", " + PermissionEnum.READ_SMS.toString() + " allPermissionsGranted [" + allPermissionsGranted + "] somePermissionsDeniedForever [" + somePermissionsDeniedForever + "]", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .ask(MainActivity.this);

