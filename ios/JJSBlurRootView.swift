//
//  BlurRootView.swift
//  react-native-blurview
//
//  Created by Juan J LF on 9/26/21.
//

import Foundation
import UIKit

@objc(JJSBlurRootView)
class JJSBlurRootView: RCTViewManager {
    
    static var MaskViews = [Int]()

    override func view() -> UIView! {
       return BlurRootView()
     }
   override class func requiresMainQueueSetup() -> Bool {
        return true
    }
}
