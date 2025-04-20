import request from '@/utils/request'

// 查询宠物信息列表
export function listInfo(query) {
  return request({
    url: '/system/info/list',
    method: 'get',
    params: query
  })
}

// 查询宠物信息详细
export function getInfo(petId) {
  return request({
    url: '/system/info/' + petId,
    method: 'get'
  })
}

// 新增宠物信息
export function addInfo(data) {
  return request({
    url: '/system/info',
    method: 'post',
    data: data
  })
}

// 修改宠物信息
export function updateInfo(data) {
  return request({
    url: '/system/info',
    method: 'put',
    data: data
  })
}

// 删除宠物信息
export function delInfo(petId) {
  return request({
    url: '/system/info/' + petId,
    method: 'delete'
  })
}
