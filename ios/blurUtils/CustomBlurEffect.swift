//
//  File.swift
//  jjutils_Example
//
//  Created by Juan J LF on 5/2/21.
//  Copyright © 2021 CocoaPods. All rights reserved.
//

import UIKit

 class CustomBlurEffect: UIBlurEffect {
    
     var blurRadius: CGFloat = 10.0
     var colorTint : UIColor?
     var colorTintAlpha : CGFloat = 1
     var saturationDeltaFactor : CGFloat = 1.8
    
    private enum Constants {
        static let blurRadiusSettingKey = "blurRadius"
        static let colorTint = "colorTint"
        static let colorTintAlpha = "colorTintAlpha"
        static let saturationDeltaFactor = "saturationDeltaFactor"
    }
    
    class func effect(with style: UIBlurEffect.Style) -> CustomBlurEffect {
        let result = super.init(style: style)
    
        object_setClass(result, self)
        let r = result as! CustomBlurEffect
        r.blurRadius = 10.0
        r.colorTintAlpha = 1
        r.saturationDeltaFactor = 1.0
        return r
    }
    
    override  func copy(with zone: NSZone? = nil) -> Any {
        let result = super.copy(with: zone)
        object_setClass(result, Self.self)
        return result
    }
    
    override  var effectSettings: AnyObject {
        get {
            let settings = super.effectSettings
            settings.setValue(blurRadius, forKey: Constants.blurRadiusSettingKey)
//            settings.setValue(UIColor.red.cgColor, forKey: Constants.colorTint)
            print("values \(String(describing: settings.allValues))")
            return settings
        }
        set {
            super.effectSettings = newValue
        }
    }
    
}
