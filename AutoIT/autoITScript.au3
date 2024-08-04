#Region ;**** Directives created by AutoIt3Wrapper_GUI ****
#AutoIt3Wrapper_Compile_Both=y
#AutoIt3Wrapper_UseX64=y
#EndRegion ;**** Directives created by AutoIt3Wrapper_GUI ****

$fileAddress=placeHodlerFilePath
$fileNameWithExtenstion=placeHolderFileNameWithExtenstion

ControlFocus("Open", "", "ToolbarWindow323")
ControlSetText("Open", "", "ToolbarWindow323", $fileAddress)
Sleep(500)
ControlFocus("Open", "", "Edit1")
Sleep(2000)
ControlSetText("Open", "", "Edit1", $fileNameWithExtenstion)
Sleep(500)
ControlClick("Open", "", "Button1")
