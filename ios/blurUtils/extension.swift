//
//  extension.swift
//  react-native-blurview
//
//  Created by Juan J LF on 9/26/21.
//

import Foundation
import UIKit

private var AssociatedObjectHandle: UInt8 = 0

extension UIVisualEffect {
    @objc var effectSettings: AnyObject {
        get {
            return objc_getAssociatedObject(self, &AssociatedObjectHandle) as AnyObject
        }
        set {
            objc_setAssociatedObject(self, &AssociatedObjectHandle, newValue, objc_AssociationPolicy.OBJC_ASSOCIATION_RETAIN_NONATOMIC)
        }
    }
}
