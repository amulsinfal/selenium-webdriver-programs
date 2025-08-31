# 🖥️ Selenium WebDriver Programs in Java
- This repository contains a comprehensive collection of **Selenium WebDriver** automation programs in Java. 
- It demonstrates essential automation skills frequently required in real-world testing — from basic element interactions to advanced browser handling.
- The purpose of this repository is to **showcase my Selenium expertise** while serving as a reusable reference for other testers.

---

## 🛠 Tech Stack
- **Language:** Java 21
- **Automation Tool:** Selenium WebDriver 4.x
- **Build Tool:** Maven
- **Testing:** Standalone `main()` methods
- **Browsers Supported:** Chrome, Firefox, Edge

---

## 📂 Categories & Descriptions

### 1. Handling Alerts
Work with JavaScript alerts by accepting, dismissing, reading text, and sending text input to prompts.  
1. [Alerts_AcceptAlert.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Alerts_AcceptAlert.java)
2. [Alerts_DismissAlert.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Alerts_DismissAlert.java)
3. [Alerts_GetTextFromAlert.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Alerts_GetTextFromAlert.java)
4. [Alerts_SendTextToAlert.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Alerts_SendTextToAlert.java)  

### 2. Checkbox Operations
Select, deselect, and verify the selection state of checkboxes in forms and settings.  
1. [Checkbox_CheckAnOption.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Checkbox_CheckAnOption.java)  
2. [Checkbox_IsOptionSelected.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Checkbox_IsOptionSelected.java)  
3. [ Checkbox_UncheckAnOption.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Checkbox_UncheckAnOption.java)  

### 3. Mouse Actions
Perform right-click, double-click, and hover interactions using Selenium’s `Actions` class.  
1. [MouseAction_DoubleClickBy_PassElement.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/MouseAction_DoubleClickBy_PassElement.java)
2. [MouseAction_DoubleClick_WithoutPassingElement.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/MouseAction_DoubleClick_WithoutPassingElement.java)
3. [MouseAction_RightClick.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/MouseAction_RightClick.java)
4. [MouseAction_HoverOverElement.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/MouseAction_HoverOverElement.java)  

### 4. Web Element & Browser Info Commands
Verify whether a web element is enabled or disabled (`isEnabled()`), and retrieve the current browser URL (`getCurrentUrl()`) and page title (`getTitle()`).  
1. [ElementIsDisabled.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/ElementIsDisabled.java)  
2. [ElementIsEnabled.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/ElementIsEnabled.java)  
3. [GetCurrentUrlCommand.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/GetCurrentUrlCommand.java)
4. [GetTitleCommand.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/GetTitleCommand.java)  

### 5. Drag and Drop
Automate dragging an element and dropping it onto another target using `dragAndDrop()`.
1. [MouseAction_DragAndDrop.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/MouseAction_DragAndDrop.java)  

### 6. Dropdown Handling
Select/deselect options in dropdowns by text, index, or value, including multi-select dropdowns.
1. [Dropdown_SelectByIndex.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Dropdown_SelectByIndex.java)
2. [Dropdown_SelectByValue.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Dropdown_SelectByValue.java)
3. [Dropdown_SelectByVisibleText.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Dropdown_SelectByVisibleText.java)
4. [Dropdown_isMultiple.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Dropdown_isMultiple.java)  
5. [Dropdown_MultipleSelect.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Dropdown_MultipleSelect.java)
6. [Dropdown_GetSelectedOption.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Dropdown_GetSelectedOption.java)
7. [Dropdown_GetOptions.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Dropdown_GetOptions.java)  
8. [Dropdown_GetAllSelectedOption.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Dropdown_GetAllSelectedOption.java)
9. [Dropdown_DeSelectValues.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Dropdown_DeSelectValues.java)

### 7. Browser and Tab Switching
Switch control between multiple browser windows or tabs.  
1. [SwitchingToWindows.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/SwitchingToWindows.java)  

### 8. Frames Handling
Switch to frames/iframes using index, name/ID, or WebElement references.  
1. [HandlingFramesUsingIndex.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/HandlingFramesUsingIndex.java)  
2. [HandlingFramesUsingName.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/HandlingFramesUsingName.java)  
3. [HandlingFramesUsingWebElement.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/HandlingFramesUsingWebElement.java)

### 9. Capturing Screenshots
Capture screenshots of full pages, individual elements, or specific sections for validation.  
1. [ScreenshotOfElement.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/ScreenshotOfElement.java)
2. [ScreenshotOfPage.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/ScreenshotOfPage.java)
3. [ScreenshotOfSection.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/ScreenshotOfSection.java)

### 10. Page Scrolling
Scroll up and down pages using JavaScript execution to interact with off-screen elements.  
1. [ScrollPageDown.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/ScrollPageDown.java)
2. [ScrollPageUp.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/ScrollPageUp.java)  

### 11. Browser Launching
Launch Chrome, Firefox, and Edge browsers with Selenium WebDriver.  
1. [LaunchChromeBrowser.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/LaunchChromeBrowser.java)  
2. [LaunchEdgeBrowser.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/LaunchEdgeBrowser.java)  
3. [LaunchFirefoxBrowser.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/LaunchFirefoxBrowser.java)  

### 12. 🧭 Navigation Commands
Automates browser navigation actions such as **opening a new URL**, moving **back** and **forward** in history, and **refreshing** the page using WebDriver’s **navigate()** methods.  
1. [Navigation.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/Navigation.java)

### 13. ⬇️ Uploading and Download File
Automates handling of uploading and downloading of files using Selenium.
1. [HandlingDownloads.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/HandlingDownloads.java)
2. [HandlingFileUpload.java](https://github.com/amulsinfal/selenium-webdriver-programs/blob/master/src/test/java/programs/HandlingFileUpload.java)

---

## 📂 Folder Structure
<img width="390" height="983" alt="" src="https://github.com/user-attachments/assets/2b8444ac-859c-4107-b98b-cb7d72568775" />

---

## ▶️ How to Run
1. Clone this repository - https://github.com/amulsinfal/selenium-webdriver-programs.git
2. Open in IDE (Eclipse/IntelliJ)
3. Run individual .java files as Java Application
