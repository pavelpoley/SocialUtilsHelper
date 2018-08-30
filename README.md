## SocialUtilsHelper
Small Android library for social events, provide quick functions like Rate App, share App and send email.

### Share App
    SocialUtils.shareApp(this);

### Rate App
    SocialUtils.rateApp(this);

### Send Email
    SocialUtils.sendEmail(this,"your_email@gmail.com","Feedback");
    
### Send SMS    
    SocialUtils.sendSMS(this,"NUMBER","BODY");
    
    
    
## How to use this library?
+ Add it in your root build.gradle at the end of repositories:

	  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		 }
	  }
  
 + Add the dependency

	   dependencies {
	        compile 'com.github.pavelpoley:SocialUtilsHelper:1.01'
	   }
    
    
 ## License
Copyright 2018 pavel poley

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
limitations under the License.
