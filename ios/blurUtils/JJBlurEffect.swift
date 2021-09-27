//
//  blurViewFile.swift
//  jjutils_Example
//
//  Created by Juan J LF on 5/2/21.
//  Copyright © 2021 CocoaPods. All rights reserved.
//

import UIKit

 class JJBlurEffect {
    
    private init(){}
    
    static  let blur = "blurRadius"
    static   let colorTint = "colorTint"
    static  let colorTintAlpha = "colorTintAlpha"
    static  let saturationDeltaFactor = "saturationDeltaFactor"
    
    static  func new(r:CGFloat,s:UIBlurEffect.Style = .light) -> UIBlurEffect  {
        if #available(iOS 14.0, *) {
            let effect = CustomBlurEffect.effect(with: s)
            effect.blurRadius = r
            return effect
        } else {
            let b = (NSClassFromString("_UICustomBlurEffect") as! UIBlurEffect.Type).init()
        
            b.setValue(r, forKeyPath: blur)
        
      
            return b
        }
    }
        
}
    

